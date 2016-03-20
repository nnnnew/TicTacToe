import java.awt.*;

public class Board {
   Cell[][] cells; 
   
   public Board() {
      cells = new Cell[GameMain.ROWS][GameMain.COLS]; 
      for (int row = 0; row < GameMain.ROWS; ++row) {
         for (int col = 0; col < GameMain.COLS; ++col) {
            cells[row][col] = new Cell(row, col); 
         }
      }
   }
 
   public void init() {
      for (int row = 0; row < GameMain.ROWS; ++row) {
         for (int col = 0; col < GameMain.COLS; ++col) {
            cells[row][col].clear(); 
         }
      }
   }
 
   public boolean isDraw() {
      for (int row = 0; row < GameMain.ROWS; ++row) {
         for (int col = 0; col < GameMain.COLS; ++col) {
            if (cells[row][col].content == Seed.EMPTY) {
               return false; 
            }
         }
      }
      return true; 
   }

   public boolean hasWon(Seed seed, int seedRow, int seedCol) {
      return (cells[seedRow][0].content == seed   
                 && cells[seedRow][1].content == seed
                 && cells[seedRow][2].content == seed
             || cells[0][seedCol].content == seed 
                 && cells[1][seedCol].content == seed
                 && cells[2][seedCol].content == seed
             || seedRow == seedCol   
                 && cells[0][0].content == seed
                 && cells[1][1].content == seed
                 && cells[2][2].content == seed
             || seedRow + seedCol == 2    
                 && cells[0][2].content == seed
                 && cells[1][1].content == seed
                 && cells[2][0].content == seed);
   }
 
   public void paint(Graphics g) {
      g.setColor(Color.GRAY);
      for (int row = 1; row < GameMain.ROWS; ++row) {
         g.fillRoundRect(0, GameMain.CELL_SIZE * row - GameMain.GRID_WIDHT_HALF,
               GameMain.CANVAS_WIDTH - 1, GameMain.GRID_WIDTH,
               GameMain.GRID_WIDTH, GameMain.GRID_WIDTH);
      }
      for (int col = 1; col < GameMain.COLS; ++col) {
         g.fillRoundRect(GameMain.CELL_SIZE * col - GameMain.GRID_WIDHT_HALF, 0,
               GameMain.GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,
               GameMain.GRID_WIDTH, GameMain.GRID_WIDTH);
      }
 
      for (int row = 0; row < GameMain.ROWS; ++row) {
         for (int col = 0; col < GameMain.COLS; ++col) {
            cells[row][col].paint(g);  
         }
      }
   }
}