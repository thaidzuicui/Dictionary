package cmd_version;

import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;
import java.util.List ;
import java.util.Scanner ;

public class DictionaryManagement
{
    // them tu bang input
    public static void insertFromCommandline ()
    {
        Scanner sc = new Scanner(System.in) ;

        int numberOfWords = sc.nextInt() ;
        sc.nextLine() ;

        for (int i=0 ; i<numberOfWords ; i++)
        {
            String ip_word_target = sc.nextLine() ;
            String ip_word_explain = sc.nextLine() ;

            Word ip = new Word(ip_word_target , ip_word_explain) ;

            Dictionary.dic.addd(ip) ;
        }

        sc.close(); ;
    }


    // them tu bang file
    public static void insertFromFile () throws IOException
    {
        FileReader reader = new FileReader("D:\\CODE\\dictionary\\src\\cmd_version\\wordd.txt") ;
        BufferedReader bufferedReader = new BufferedReader(reader) ;

        String ip_word_target ;
        String ip_word_explain ;

        while((ip_word_target=bufferedReader.readLine()) != null &&
              (ip_word_explain=bufferedReader.readLine()) != null )
        {
            Word ip = new Word(ip_word_target , ip_word_explain) ;
            Dictionary.dic.addd(ip) ;
        }

        bufferedReader.close() ;
    }

    // tra cuu tu
    public static void dictionaryLookup (String search)
    {
        if((Dictionary.dic.findWord(search)) != null)
        {
            System.out.println("Meaning : " + Dictionary.dic.findWord(search).getWord_explain()) ;
        }
        else
        {
            System.out.println("Không tìm thấy trong từ điển") ;
        }
    }

    // tim kiem tu vung co chua x o dau
    public static void dictionarySearch (String x)
    {
        // check if wrong
        List<Word> pr = Dictionary.dic.searchWord(x) ;

        for(int i=0 ; i<pr.size() ; i++)
        {
            System.out.println("- " + pr.get(i).getWord_target()) ;
        }
    }


    // xuat tu ra file
    public static void dictionaryExportToFile () throws IOException
    {
        Dictionary.dic.export() ;
    }


    // them du lieu tu vung
    public static void add_Word (Word x)
    {
        Dictionary.dic.addd(x) ;
    }


    // sua du lieu tu vung
    public static void fix_Word (String tg , String ep)
    {
        Dictionary.dic.fix(tg , ep) ;
    }


    // xoa du lieu tu vung
    public static void remove_Word (String x)
    {
        Dictionary.dic.remove(x) ;
    }

}