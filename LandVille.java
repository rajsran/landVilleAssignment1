import java.util.Scanner;

class LandVille
{
    //2D array to display the land
    private int[][] land;

    //boolean variable to check whether House exists or not
    boolean hasHouse;

    public static void main(String[] args)
    {
        //Rows and columsn of land
        int rowsLand=0;
        int columnsLand=0;

        //Rows and columsn of House
        int rowsHouse;
        int columnsHouse;

        //variable for cases so that particular method will be called according to user input
        int choice=0;

        //create object of Scanner class to read user input
        Scanner sc = new Scanner(System.in);

        //loop to check whether the value of row of land between 1 and 10
        while(rowsLand <= 0 || rowsLand > 10)
        {
            System.out.println("Enter row number of the land:");
            rowsLand = sc.nextInt();
            if (rowsLand <= 0 || rowsLand > 10)
            {
                System.out.println("Row should be greater than 0 and less than or equal to 10");
                System.out.println("Enter row number of the land:");
                rowsLand = sc.nextInt();
            }
        }

        //loop to check whether the value of column of land between 1 and 10
        while(columnsLand <= 0 || columnsLand > 10)
        {
            System.out.println("Enter column number of the land:");
            columnsLand = sc.nextInt();
            if (columnsLand <= 0 || columnsLand > 10)
            {
                System.out.println("Column should be greater than 0 and less than or equal to 10");
                System.out.println("Enter column number of the land:");
                columnsLand = sc.nextInt();
            }
        }

        //creating an object of LandVille class
        LandVille villa=new LandVille(rowsLand, columnsLand);

        //Main Menu starts from here
        while(choice!=4)
        {
            System.out.println("Choose from the menu: 1. Build a house, 2. Display land 3. Clear the land 4. Quit");
            choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                    if(villa.hasHouse)
                    {
                        System.out.println("House already exists!");
                        break;
                    }

                    System.out.println("Enter row of the house:");

                    rowsHouse = sc.nextInt();

                    //Checking whether the difference between rows of land and house is greater than or equal to 2
                    if (rowsLand-rowsHouse<2)
                    {
                        System.out.println("Invalid input. Row of house needs to less than or equal to " + (rowsLand-2) + ". No House is built");
                        break;
                    }

                    System.out.println("Enter column of the house:");

                    columnsHouse = sc.nextInt();

                    //Checking whether the difference between columns of land and house is greater than or equal to 2
                    if (columnsLand-columnsHouse<2)
                    {
                        System.out.println("Invalid input. Column of house needs to less than or equal to " + (columnsLand-2) + ". No House is built");
                        break;
                    }

                    villa.buildHouse(rowsHouse+2, columnsHouse+2);
                    //villa.hasHouse=true;
                    break;

                case 2:
                    villa.displayLand();
                    break;

                case 3:
                    villa.clearLand();
                    System.out.println("Land cleared");
                    villa.displayLand();
                    break;

                case 4:
                    System.out.println("Program ends.");
                    break;
            }
        }
    }

    public LandVille(int maxRows, int maxColumns)
    {
        //Initializing the land array with 0 at every index

        land=new int[maxRows][maxColumns];

        for(int i=0;i<maxRows;i++)
        {
            for(int j=0;j<maxColumns;j++)
            {
                land[i][j]=0;
            }
        }

        //Initialize the variable to denote that there is not House initially
        hasHouse=false;
    }


    public void displayLand()
    {
        //loop on 2D array to print the values at every index
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[i].length;j++)
            {
                System.out.print(land[i][j] + " ");
            }
            System.out.println();
        }
    }



    public void clearLand()
    {
        //below loops sets every value to 0 in 2D array
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[i].length;j++)
            {
                land[i][j]=0;
            }
        }

        //sets hasHouse to false means that there is no house
        hasHouse=false;
    }


    public void buildHouse(int rows, int columns)
    {
        //the below loop is used to build the house. 8 represents the house & 1 represents the fencing
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if((i==0 || i==rows-1))
                {
                    land[i][j]=1;
                }
                else if(j==0 || j==columns-1)
                {
                    land[i][j]=1;
                }
                else
                {
                    land[i][j]=8;
                }
            }
        }

        hasHouse=true;
        //after buulding the house, the below method displays the land
        displayLand();
    }

}