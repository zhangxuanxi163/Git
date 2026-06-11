"""
聘书文档合并工具
将当前目录下所有 .docx 文件合并为一个文件，保持原有格式和样式。
需要安装 Microsoft Word。
"""
import os
import sys
import time
import pythoncom
import win32com.client

# Word 常量
wdStory = 6
wdPageBreak = 7
wdDoNotSaveChanges = 0


def merge_docx_files():
    # 当前目录
    current_dir = os.path.dirname(os.path.abspath(sys.argv[0]))

    # 收集所有 .docx 文件（排除临时文件和已合并的输出文件）
    all_files = sorted([
        f for f in os.listdir(current_dir)
        if f.lower().endswith('.docx')
        and not f.startswith('~$')
        and f != '合并_聘书.docx'
        and f != 'merged_聘书.docx'
        and not f.startswith('合并')
    ])

    if len(all_files) < 2:
        print(f"错误：当前目录下只找到 {len(all_files)} 个 .docx 文件，至少需要 2 个才能合并。")
        print(f"当前目录: {current_dir}")
        return False

    print(f"找到 {len(all_files)} 个 .docx 文件，开始合并...")
    print(f"当前目录: {current_dir}")
    print()

    output_path = os.path.join(current_dir, '合并_聘书.docx')

    pythoncom.CoInitialize()
    word = None
    merged_doc = None

    try:
        print("正在启动 Word...")
        word = win32com.client.Dispatch("Word.Application")
        word.Visible = False
        word.DisplayAlerts = 0
        word.ScreenUpdating = False

        # 打开第一个文件作为基础
        first_path = os.path.join(current_dir, all_files[0])
        print(f"加载第 1/{len(all_files)} 个文件: {all_files[0]}")
        merged_doc = word.Documents.Open(first_path)

        selection = word.Selection

        # 逐个追加其余文件
        for idx, filename in enumerate(all_files[1:], start=1):
            filepath = os.path.join(current_dir, filename)

            # 跳转到文档末尾
            selection.EndKey(wdStory)
            # 插入分页符
            selection.InsertBreak(wdPageBreak)
            # 插入下一个文件
            selection.InsertFile(filepath)

            if idx % 30 == 0:
                print(f"  已处理 {idx+1}/{len(all_files)} 个文件...")

        print(f"  已处理 {len(all_files)}/{len(all_files)} 个文件")
        print()
        print("正在保存合并后的文档...")
        merged_doc.SaveAs2(os.path.abspath(output_path))
        merged_doc.Close()
        merged_doc = None

        file_size_mb = os.path.getsize(output_path) / 1024 / 1024
        print(f"合并完成！")
        print(f"输出文件: {output_path}")
        print(f"文件大小: {file_size_mb:.1f} MB")
        print(f"共合并 {len(all_files)} 个文档")
        return True

    except Exception as e:
        print()
        print(f"错误: {e}")
        print()
        print("可能的原因:")
        print("  1. 当前电脑未安装 Microsoft Word")
        print("  2. Word 正在运行中（请先关闭所有 Word 窗口后重试）")
        print("  3. 某些 .docx 文件已损坏")
        return False
    finally:
        if merged_doc is not None:
            try:
                merged_doc.Close(0)
            except Exception:
                pass
        if word is not None:
            try:
                word.Quit()
            except Exception:
                pass
        pythoncom.CoUninitialize()


if __name__ == '__main__':
    success = merge_docx_files()
    print()
    print("按回车键退出...")
    input()
    sys.exit(0 if success else 1)
