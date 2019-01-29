import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.ArrayList

class NullCharConverter{

    private val nullByteCode = 0 //0 == 0x00(NULL),
    private val colonByteCode = 58 //58 == 0x3A(:)
    private val tabByteCode = 9 //9 == 0x09(TAB),
    private val sharpByteCode = 35 //35 == 0x23(#)

    /**
     * NULL文字を特定の記号に置き換えたファイルをNULL文字を含むファイルに戻すためのメソッドです。<br>
     * @param  beforeFileName NULL文字に戻したいファイル名<br>
     *  @param afterFileName NULL文字が含まれるデータに戻したデータの保存先のファイル名 */
    fun restoreNullChar(beforeFileName: String, afterFileName: String){
        val fileInput = FileInputStream(beforeFileName)
        val fileOutput = FileOutputStream(afterFileName)

        var next = fileInput.read()
        while(next != -1){

            val tmpNext = when(next){
                colonByteCode -> nullByteCode
                sharpByteCode -> tabByteCode
                else -> next
            }

            fileOutput.write(tmpNext)
            next = fileInput.read()

        }

        fileInput.close()
        fileOutput.flush()
        fileOutput.close()
    }

    /**
     * NULL文字を特定の記号に置き換えるためのメソッドです
     * @param beforeFileName NULL文字が含まれるファイル
     * @param afterFileName NULL文字変換後のファイル
     */
    fun replacementNullChar(beforeFileName: String, afterFileName: String){
        val fileInput = FileInputStream(beforeFileName)
        val fileOutput = FileOutputStream(afterFileName)

        var count = 0

        var next = fileInput.read()
        while(next != -1){


            val tmpNext = when(next){
                nullByteCode -> colonByteCode
                tabByteCode -> sharpByteCode
                else -> next
            }

            fileOutput.write(tmpNext)

            next = fileInput.read()
            count++

        }
        fileInput.close()
        fileOutput.flush()
        fileOutput.close()

    }
}