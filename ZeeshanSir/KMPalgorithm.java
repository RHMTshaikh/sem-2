package ZeeshanSir;

import java.util.Arrays;

public class KMPalgorithm{
    public static void main(String[] args) {
        String text = "compare each In Visual Studio Code (VS Code), you can use a combination of keyboard shortcuts and command palette commands to create a file in a specific directory and open it in the editor. Here's a step-by-step guide:\r\n" + //
                        "\r\n" + //
                        "### Step-by-Step Process\r\n" + //
                        "\r\n" + //
                        "1. **Open the Command Palette**:\r\n" + //
                        "   - Press `Ctrl + Shift + P` (or `Cmd + Shift + P` on macOS) to open the Command Palette.\r\n" + //
                        "\r\n" + //
                        "2. **Create a New File**:\r\n" + //
                        "   - In the Command Palette, type `>File: New File` and select it. This creates a new untitled file in the currently open directory.\r\n" + //
                        "   - Alternatively, you can use the shortcut `Ctrl + N` (or `Cmd + N` on macOS) to create a new file.\r\n" + //
                        "\r\n" + //
                        "3. **Save the New File in a Specific Directory**:\r\n" + //
                        "   - With the new file open, press `Ctrl + S` (or `Cmd + S` on macOS) to save the file.\r\n" + //
                        "   - In the Save File dialog, navigate to the desired directory, enter the file name, and save it. This will also open the file in the editor.\r\n" + //
                        "\r\n" + //
                        "### Creating and Opening a File Directly in a Specific Directory\r\n" + //
                        "\r\n" + //
                        "To directly create and open a file in a specific directory, you can use the built-in terminal or an extension like \"File Utils\". Here’s how:\r\n" + //
                        "\r\n" + //
                        "#### Using Built-In Terminal\r\n" + //
                        "\r\n" + //
                        "1. **Open the Terminal**:\r\n" + //
                        "   - Press `Ctrl + `` ` (backtick) or select `View > Terminal` from the menu to open the integrated terminal.\r\n" + //
                        "\r\n" + //
                        "2. **Navigate to the Desired Directory**:\r\n" + //
                        "   - Use the `cd` command to navigate to the specific directory where you want to create the file. For example:\r\n" + //
                        "     ```sh\r\n" + //
                        "     cd path/to/your/directory\r\n" + //
                        "     ```\r\n" + //
                        "\r\n" + //
                        "3. **Create the New File**:\r\n" + //
                        "   - Use the `touch` command to create a new file. For example:\r\n" + //
                        "     ```sh\r\n" + //
                        "     touch newfile.txt\r\n" + //
                        "     ```\r\n" + //
                        "\r\n" + //
                        "4. **Open the New File**:\r\n" + //
                        "   - Type the name of the new file and press `Enter` to open it in the editor. For example:\r\n" + //
                        "     ```sh\r\n" + //
                        "     code newfile.txt\r\n" + //
                        "     ```\r\n" + //
                        "\r\n" + //
                        "#### Using the \"File Utils\" Extension\r\n" + //
                        "\r\n" + //
                        "1. **Install the Extension**:\r\n" + //
                        "   - Go to the Extensions view by clicking the Extensions icon in the Activity Bar on the side of the window or pressing `Ctrl + Shift + X` (or `Cmd + Shift + X` on macOS).\r\n" + //
                        "   - Search for \"File Utils\" and install it.\r\n" + //
                        "\r\n" + //
                        "2. **Create a New File in a Specific Directory**:\r\n" + //
                        "   - Right-click on the desired directory in the Explorer view.\r\n" + //
                        "   - Select `File Utils: New File` from the context menu.\r\n" + //
                        "   - Enter the file name, and it will be created and opened in the editor.\r\n" + //
                        "\r\n" + //
                        "### Summary\r\n" + //
                        "\r\n" + //
                        "- **Command Palette**: `Ctrl + Shift + P` (or `Cmd + Shift + P`), type `>File: New File`, save in the desired directory.\r\n" + //
                        "- **Terminal**: `Ctrl + `` ` (navigate with `cd`, create with `touch`, open with `code`).\r\n" + //
                        "- **Extensions**: Install \"File Utils\" to simplify the process.\r\n" + //
                        "\r\n" + //
                        "Using these methods, you can efficiently create and open files in specific directories within VS Code. element.";

        String pattern = "directories";

        System.out.println(KPS(text, pattern));
    }
    static int KPS(String text, String pattern){
        char[] chars = pattern.toCharArray();
        int[] LPS = LPS(pattern);
        System.out.println(Arrays.toString(LPS));
        int j= -1;
        
        int len = text.length();
        int k = len - chars.length ;

        for (int i = 0; i <= k; ) {
            while (text.charAt(i) == chars[j+1]) {
                if (j+1 == chars.length-1) {
                    return i - chars.length +1;
                } 
                j++;
                if (i < len-1) i++;
            }
            if(i-j > k) return -1;

            if(j > -1)  j= LPS[j];

            i++;
        }
        return -1;
    }
    static int[] LPS(String pattern){
        char[] arr = pattern.toCharArray();

        int[] LPS = new int[arr.length];
        LPS[0] = -1;
        int j = -1;

        for (int i = 0; i < arr.length-1; ) {
            while (i < arr.length-1 && arr[++j] == arr[++i]) {
                LPS[i] = j;
            }
            if(arr[j] != arr[i]){
                if(j==0) LPS[i]= -1; 
                else     i--;
            }  
            j = -1;
        }
        return LPS;
    }
}