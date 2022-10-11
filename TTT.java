import java.util.HashSet;
import java.util.Scanner;

public class TTT {
    static HashSet<Integer> userset=new HashSet<Integer>();
    static HashSet<Integer> cpuset=new HashSet<Integer>();

    public static void main(String[] args) {

        /*make 2d array for the board*/
        char [][]g_board=
                {
                        {' ','|',' ','|',' '},
                        {'-','|','-','|','-'},
                        {' ','|',' ','|',' '},
                        {'-','|','-','|','-'},
                        {' ','|',' ','|',' '},
                };
      print_board(g_board);

      Scanner sc= new Scanner(System.in);


      while(true)
      {
          /*for user input*/
          System.out.print("Enter position 1 to 9: ");
          int upos = sc.nextInt();
          while(userset.contains(upos)|| cpuset.contains(upos))
          {
              System.out.println();
              System.out.print("RETRY-Enter position 1 to 9: ");
              upos = sc.nextInt();
          }
          pholder(g_board,upos,"You");

//          print_board(g_board);
          String res = chkwinner();
          if(res.length()>0)
          {
              System.out.println(res);
              break;
          }


          /*for cpu input*/
//          System.out.print("Enter position 1 to 9: ");
          int cpos = random();
          while(userset.contains(cpos)|| cpuset.contains(cpos))
          {
              cpos = random();
          }
          pholder(g_board,cpos,"CPU");

          print_board(g_board);
          res = chkwinner();
          if(res.length()>0)
          {
              System.out.println(res);
              break;
          }
      }
    }

    /*method for generating random cpu input*/
    static int random()
    {
        int max=9;
        int min=1;
        int range =max-min+1;
        int cpuin = (int)(Math.random()*range)+min;
        return cpuin;
    }

    /*check winnner method*/
    static String chkwinner()
    {
        HashSet<Integer> r1 = new HashSet<Integer>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2 = new HashSet<Integer>();
        r2.add(4);r2.add(5);r2.add(6);
        HashSet<Integer> r3 = new HashSet<Integer>();
        r3.add(7);r3.add(8);r3.add(9);
        HashSet<Integer> c1 = new HashSet<Integer>();
        c1.add(1);c1.add(4);c1.add(7);
        HashSet<Integer> c2 = new HashSet<Integer>();
        c2.add(2);c2.add(5);c2.add(8);
        HashSet<Integer> c3 = new HashSet<Integer>();
        c3.add(3);c3.add(6);c3.add(9);
        HashSet<Integer> d1 = new HashSet<Integer>();
        d1.add(1);d1.add(5);d1.add(9);
        HashSet<Integer> d2 = new HashSet<Integer>();
        d2.add(3);d2.add(5);d2.add(7);

        /*hashset of the above hashsets*/
        HashSet<HashSet> h1=new HashSet<HashSet>();
        h1.add(r1);h1.add(r2);h1.add(r3);
        h1.add(c1);h1.add(c2);h1.add(c3);
        h1.add(d1);h1.add(d2);

        for(HashSet c:h1)
        {
            if(userset.containsAll(c))
            {
                return "YOU WON";
            }
            else if (cpuset.containsAll(c)) {
                return "YOU LOST";
            }
        }
        if (userset.size()+ cpuset.size()==9)
        {
            return "DRAW";
        }
        return "";

    }

    /*method to print board*/
    static void print_board(char[][]g_board)
    {
        for (int r=0;r< g_board.length;r++)
        {
            for (int c=0;c< g_board[r].length;c++)
            {
                System.out.print(g_board[r][c]);
            }
            System.out.println();
        }
    }

    /*method for position selected by user*/
    static void pholder(char[][]g_board,int pos,String user)
    {
        char syb='X';
        if(user.equals("You"))
        {
            syb='X';
            userset.add(pos);
        }
        else if (user.equals("CPU"))
        {
            syb='O';
            cpuset.add(pos);
        }
        switch(pos)
        {
            case 1:
            {
                g_board[0][0]=syb;
            }break;
            case 2:
            {
                g_board[0][2]=syb;
            }break;
            case 3:
            {
                g_board[0][4]=syb;
            }break;
            case 4:
            {
                g_board[2][0]=syb;
            }break;
            case 5:
            {
                g_board[2][2]=syb;
            }break;
            case 6:
            {
                g_board[2][4]=syb;
            }break;
            case 7:
            {
                g_board[4][0]=syb;
            }break;
            case 8:
            {
                g_board[4][2]=syb;
            }break;
            case 9:
            {
                g_board[4][4]=syb;
            }break;
            default:
            {
                System.out.println("Invalid Choice");
            }
        }

    }















}