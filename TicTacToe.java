import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
private static final int SIZE = 3; // Grid size 3x3
private JButton[][] buttons;
private char currentPlayer;
private boolean gameOver;
public TicTacToe() {
// Frame settings
setTitle("TicTacToe - ANANYA PANDA - 2328069");
setSize(400, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Initialize the board and other variables
buttons = new JButton[SIZE][SIZE];
currentPlayer = 'X';
gameOver = false;
// Panel for the board
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(SIZE, SIZE));
// Initialize buttons and add listeners
for (int i = 0; i < SIZE; i++) {
for (int j = 0; j < SIZE; j++) {
buttons[i][j] = new JButton("");
buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
buttons[i][j].setFocusPainted(false);
buttons[i][j].setBackground(Color.WHITE);
buttons[i][j].addActionListener(this);
panel.add(buttons[i][j]);
}
}
// Add panel to frame
add(panel);
// Set frame visibility
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
if (gameOver) {
return; // If the game is over, no more moves can be made
}
// Find the button that was clicked
JButton clickedButton = (JButton) e.getSource();
// If the button is already marked, do nothing
if (!clickedButton.getText().equals("")) {
return;
}
// Mark the button with the current player's symbol
clickedButton.setText(String.valueOf(currentPlayer));
clickedButton.setEnabled(false);
// Check for a winner after each move
if (checkForWinner()) {
JOptionPane.showMessageDialog(this, currentPlayer + " wins!", "GameOver", JOptionPane.INFORMATION_MESSAGE);
gameOver = true;
} 
else if (isBoardFull()) {
JOptionPane.showMessageDialog(this, "It's a draw!", "Game Over",JOptionPane.INFORMATION_MESSAGE);
gameOver = true;
} 
else {
// Switch to the other player
currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}
}
// Check if there is a winner
private boolean checkForWinner() {
// Check rows, columns, and diagonals for a win
for (int i = 0; i < SIZE; i++) {
if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
return true; // Row win
}
if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
return true; // Column win
}
}
// Check diagonals
if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
return true; // Main diagonal win
}
if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) && buttons[1][1].getText().equals(String.valueOf(currentPlayer)) && buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
return true; // Anti-diagonal win
}
return false;
}
// Check if the board is full (i.e., a draw)
private boolean isBoardFull() {
for (int i = 0; i < SIZE; i++) {
for (int j = 0; j < SIZE; j++) {
if (buttons[i][j].getText().equals("")) {
return false;
}
}
}
return true; // No empty spaces left
}
public static void main(String[] args) {
// Run the game
new TicTacToe();
}
}