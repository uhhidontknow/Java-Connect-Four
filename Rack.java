public class Rack{
    String[][] r = new String[11][13]; // 7 columns, 6 rows. 13 columns for rich formatting, 11 rows for rich formatting
    
    public Rack(){
        for(int row = 0; row < r.length; row++){
            for(int col = 0; col < r[0].length; col++){
                if(row % 2 == 1){
                    r[row][col] = "-";
                }else{
                    if(col % 2 == 1){
                        r[row][col] = "|";
                    }else{
                        r[row][col] = " ";
                    }
                }
            }
        }
    }
    
    public void placePiece(int col){
        col = getRealPos(col);
        for(int row = r.length - 1; row >= 0; row--){
            if(r[row][col].equalsIgnoreCase(" ")){
                r[row][col] = "X";
                break;
            }
            if(row == 0 && !r[row][col].equalsIgnoreCase(" ")){
                System.out.println("There is no more room on that column, try again!");
            }
        }
        
    }
    
    public void cpuPlace(int col){ //for testing purposes
        col = getRealPos(col);
        for(int row = r.length - 1; row >= 0; row--){
            if(r[row][col].equalsIgnoreCase(" ")){
                r[row][col] = "O";
                break;
            }
            if(row == 0 && !r[row][col].equalsIgnoreCase(" ")){
                System.out.println("There is no more room on that column, try again!");
            }
        }
        
    }
    
    public int getRealPos(int x){
        return (x - 1) * 2;
    }
    
    public void update(){
        System.out.println(toString() + "\n");
    }

    public void play(int col){
        placePiece(col);
        update();
    }
    
    public void cpuPlay(){
        int col = 1;
        while(col % 2 != 0){
            col = (int) Math.floor(Math.random() * r[0].length);
            if(r[0][col].equalsIgnoreCase("X") || r[0][col].equalsIgnoreCase("O")){
                col = 1;
            }
        }
        for(int row = r.length - 1; row >= 0; row--){
            if(r[row][col].equalsIgnoreCase(" ")){
                r[row][col] = "O";
                break;
            }
            // if(row == 0 && !r[row][col].equalsIgnoreCase(" ")){
                
            // }
        }
        update();
    }
    
    public boolean spacesAvailable(){
        for(int row = 0; row < r.length; row++){
            for(int col = 0; col < r[0].length; col++){
                if(r[row][col].equalsIgnoreCase(" ")){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkFour(String token){ // true if win
        return checkHor(token) || checkVer(token) || checkDiag(token);
    }
    
    public boolean checkHor(String token){
        int counter = 0;
        for(int row = 0; row < r.length; row += 2){
            for(int col = 0; col < r[0].length; col += 2){
                if(r[row][col].equalsIgnoreCase(token)){
                    counter++;
                }
                if(!r[row][col].equalsIgnoreCase(token)){
                    counter = 0;
                }
                if(counter == 4){
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public boolean checkVer(String token){
        int counter = 0;
        for(int col = 0; col < r[0].length; col += 2){
            for(int row = 0; row < r.length; row += 2){
                if(r[row][col].equalsIgnoreCase(token)){
                    counter++;
                }
                if(!r[row][col].equalsIgnoreCase(token)){
                    counter = 0;
                }
                if(counter == 4){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkDiag(String token){
        for(int row = 0; row < r.length; row += 2){
            for(int col = 0; col < r[0].length; col += 2){
                if(row + 6 < r.length && col + 6 < r[0].length){
                    if(r[row][col].equalsIgnoreCase(token) && r[row + 2][col + 2].equalsIgnoreCase(token) && r[row + 4][col + 4].equalsIgnoreCase(token) && r[row + 6][col + 6].equalsIgnoreCase(token)){
                        return true;
                    }
                }
                if(row + 6 < r.length && col - 6 >= 0){
                    if(r[row][col].equalsIgnoreCase(token) && r[row + 2][col - 2].equalsIgnoreCase(token) && r[row + 4][col - 4].equalsIgnoreCase(token) && r[row + 6][col - 6].equalsIgnoreCase(token)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public void cleanup(){
        for(int row = 0; row < r.length; row++){
            for(int col = 0; col < r[0].length; col++){
                if(row % 2 == 1){
                    r[row][col] = "-";
                }else{
                    if(col % 2 == 1){
                        r[row][col] = "|";
                    }else{
                        r[row][col] = " ";
                    }
                }
            }
        }
    }
    
    public String toString(){
        String returnVal = "";
        for(int row = 0; row < r.length; row++){
            for(int col = 0; col < r[0].length; col++){
                returnVal += r[row][col];
            }
            returnVal += "\n";
        }
        return returnVal;
    }
    
}