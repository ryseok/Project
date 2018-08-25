package com.encore.funshop.model;

public class Othello {
	private final int n = 8;
	final int rDiff[] = {1, -1, 0, 0, -1, 1, -1, 1};
    final int cDiff[] = {0, 0, 1, -1, 1, 1, -1, -1};
	private int board[][]; //0:��ĭ, -1:�浹, 1:�鵹
	
	public Othello() {
		board = new int[n][n];
		board[n/2-1][n/2-1] = 1;
		board[n/2-1][n/2] = -1;
		board[n/2][n/2-1] = -1;
		board[n/2][n/2] = 1;
	}
	
	public void putStone(int r, int c, int stone) {
		board[r][c] = stone;
         
        for(int k=0, moveR=r, moveC=c, cnt=0; k<n; ++k, moveR=r, moveC=c, cnt=0) {
        	while(true) {
        		moveR += rDiff[k];
        		moveC += cDiff[k];
                if(moveR > n-1 || moveR < 0 || moveC > n-1 || moveC < 0 || board[moveR][moveC] == 0) break;
                else if(board[moveR][moveC] == stone) {
                	for(int l=0; l<cnt; ++l) {
                		moveR -= rDiff[k];
                     	moveC -= cDiff[k];
                     	board[moveR][moveC] = stone;
                    }
                    break;
                }
                else cnt++;
            }
         }
	}
	
	public boolean isPutable(int r, int c, int stone) {
		if(board[r][c] != 0) return false;
		else {
			for(int k=0, moveR=r, moveC=c; k<n; ++k, moveR=r, moveC=c) {
				boolean find_flag = false;
	        	while(true) {
	        		moveR += rDiff[k];
	        		moveC += cDiff[k];
	                if(moveR > n-1 || moveR < 0 || moveC > n-1 || moveC < 0 || board[moveR][moveC] == 0) break;
	                else if(board[moveR][moveC] == -stone) {
	                	find_flag = true;
	                }
	                else if(board[moveR][moveC] == stone) {
	                	if(find_flag) return true;
	                	else break;
	                }
	            }
	         }
		}
		return false;
	}
	
	public String isFinish() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(isPutable(i,j,-1) || isPutable(i,j,1)) return "playing";
			}
		}
		
		int black = 0;
		int white = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int stone = board[i][j];
				if(stone == -1) black++;
				else if(stone == 1) white++;
			}
		}
		if(black > white) return "black"; //������ �¸�
		else if(black < white) return "white"; //��� �¸�
		else return "draw"; //���º�
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	/* AI */
	public void putStone_AI(int stone) {
		int maxScore = 0;
		int maxR = 0, maxC = 0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(isPutable(r, c, stone)) {
					int score = getScore(r, c, stone);
					if(score > maxScore) {
						maxScore = score;
						maxR = r;
						maxC = c;
					}
				}
			}
		}
		if(maxScore > 0) {
			putStone(maxR, maxC, stone);			
		}
	}
	
	public int getScore(int r, int c, int stone) {
		int score = 0;
		for(int k=0, moveR=r, moveC=c, cnt=0; k<n; ++k, moveR=r, moveC=c, cnt=0) {
			while(true) {
	        	moveR += rDiff[k];
	        	moveC += cDiff[k];
	            if(moveR > n-1 || moveR < 0 || moveC > n-1 || moveC < 0 || board[moveR][moveC] == 0) break;
	            else if(board[moveR][moveC] == stone) {
	                for(int l=0; l<cnt; ++l) {
	                	moveR -= rDiff[k];
	                    moveC -= cDiff[k];
	                    score++;
	                }
	                break;
	            }
	            else cnt++;
	        }
		}
		return score;
	}
}
