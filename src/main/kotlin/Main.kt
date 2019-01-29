

fun main(args: Array<String>){

    val nullCon = NullCharConverter()
    nullCon.replacementNullChar("", "new_non_null.xml") //この場合プロジェクトのフォルダ内にnew_non_null.xmlファイルが作成されます
    //nullCon.restoreNullChar("new_non_null.xml", "restore_test.xml")


}

