package cmd_version;

import java.io.IOException ;
import java.util.InputMismatchException;
import java.util.Scanner ;

public class DictionaryCommandline
{
    public static void showAllWords ()
    {
        Dictionary.dic.showWord() ;
    }

    public static void dictionaryBasic ()
    {
        DictionaryManagement.insertFromCommandline() ;
        showAllWords() ;
    }

    public static void dictionaryBasic2 () throws IOException
    {
        DictionaryManagement.insertFromFile() ;
        showAllWords() ;
    }

    public static void dictionaryAdvanced () throws IOException
    {
        boolean check = true ;

        while(check)
        {
            // menu display
            System.out.println("Welcome to My Application!") ;
            System.out.print("[0]  Exit\n[1]  Add\n[2]  Remove\n[3]  Update\n[4]  Display\n[5]  Lookup\n") ;
            System.out.print("[6]  Search\n[7]  Game\n[8]  Import from file\n[9]  Export to file\n") ;
            System.out.println("Your action : ") ;

            // user selection
            Scanner sc = new Scanner(System.in) ;
            int sl = -1 ;

            try
            {
                sl = sc.nextInt() ;
            }
            catch (InputMismatchException e)
            {
            }

            sc.nextLine() ; // remove down line


            if(sl == 0) // Quit
            {
                System.out.print("QUIT!") ;
                check = false ;
            }
            else if(sl == 1) // Add
            {
                System.out.println("Word you want to add :") ;
                String wt = sc.nextLine() ;

                System.out.println("Meaning :") ;
                String we = sc.nextLine() ;

                DictionaryManagement.add_Word(new Word(wt,we)) ;
            }
            else if(sl == 2) // Remove
            {
                System.out.println("Word you want to remove :") ;
                String rm = sc.nextLine() ;

                DictionaryManagement.remove_Word(rm) ;
            }
            else if(sl == 3) // Update
            {
                System.out.println("Word you want to fix :") ;
                String tg = sc.nextLine() ;

                System.out.println("Edit meaning to :") ;
                String ep = sc.nextLine() ;

                DictionaryManagement.fix_Word(tg,ep) ;
            }
            else if(sl == 4)
            {
                showAllWords() ;
            }
            else if(sl == 5)
            {
                System.out.println("Lookup : ") ;
                String search = sc.nextLine().trim().toLowerCase() ;

                DictionaryManagement.dictionaryLookup(search) ;
            }
            else if(sl == 6)
            {
                System.out.println("Search : ") ;
                String sr = sc.nextLine() ;

                System.out.println("Result : ") ;
                DictionaryManagement.dictionarySearch(sr) ;
            }
            else if(sl == 8)
            {
                DictionaryManagement.insertFromFile() ;
            }
            else if(sl == 9)
            {
                DictionaryManagement.dictionaryExportToFile() ;
            }
            else
            {
                System.out.println("Action not supported") ;
            }
        }
    }
}