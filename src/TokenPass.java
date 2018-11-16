public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass (int playerCount)
    {
        board = new int[playerCount];
        for (int i =0; i < playerCount; i++)
        {
            board[i] = 1 + (int) (10 * Math.random());
        }
        currentPlayer = (int) (playerCount * Math.random());
    }
    public void distributeCurrentPlayerTokens() {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while(numToDistribute > 0) {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }
    public void printBoard() {
        String Board = "";
        String temp = "";
        int playerValue = 0;
        for(int i = 0 ;i<board.length;i++)
        {
            playerValue = board[i];
            temp = "Player" + i + ": " + playerValue + " ";
            Board += temp;
        }
        System.out.println(Board);
    }
    public int gameOver()
    {
        if(board[currentPlayer] == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public int nextPlayer(){
        return currentPlayer++;
    }


}
