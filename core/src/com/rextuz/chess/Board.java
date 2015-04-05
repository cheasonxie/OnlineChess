package com.rextuz.chess;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rextuz.chess.anim.Available;
import com.rextuz.chess.pieces.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Board extends UnicastRemoteObject {
    private static final long serialVersionUID = 1L;
    public Pieces pieces = new Pieces();
    public List<Available> moves = new ArrayList<Available>();
    private String color;
    private Sprite sprite;
    private Texture texture;

    public Board(String color) throws RemoteException {
        if (color.equals("white"))
            texture = new Texture("assets/chess_board.png");
        else
            texture = new Texture("assets/chess_board_black.png");
        sprite = new Sprite(texture);

        this.color = color;
        String foeColor = color.equals("white") ? "black" : "white";

        pieces.add(new Rook(0, 0, color, this));
        pieces.add(new Rook(7, 0, color, this));
        pieces.add(new Knight(1, 0, color, this));
        pieces.add(new Knight(6, 0, color, this));
        pieces.add(new Bishop(2, 0, color, this));
        pieces.add(new Bishop(5, 0, color, this));
        pieces.add(new Queen(3, 0, color, this));
        pieces.add(new King(4, 0, color, this));
        for (int x = 0, y = 1; x < 8; x++)
            pieces.add(new Pawn(x, y, color, this));

        pieces.add(new Rook(0, 7, foeColor, this));
        pieces.add(new Rook(7, 7, foeColor, this));
        pieces.add(new Knight(1, 7, foeColor, this));
        pieces.add(new Knight(6, 7, foeColor, this));
        pieces.add(new Bishop(2, 7, foeColor, this));
        pieces.add(new Bishop(5, 7, foeColor, this));
        pieces.add(new Queen(3, 7, foeColor, this));
        pieces.add(new King(4, 7, foeColor, this));
        for (int x = 0, y = 6; x < 8; x++)
            pieces.add(new Pawn(x, y, foeColor, this));
    }

    public static void log(Object s) {
        try {
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println("null");
        }
    }

    public static String log(float x, float y) {
        String s = "(" + x + ", " + y + ")";
        System.out.println(s);
        return s;
    }

    public static void log(Piece p) {
        System.out.println("Name: " + p.getClass().getSimpleName());
        System.out.println("Color: " + p.getColor());
        System.out.println("Place: " + log(p.getX(), p.getY()));
        System.out.print("Moves: ");
        if (!p.moves().isEmpty())
            for (Available a : p.moves())
                System.out.print("(" + a.getX() + ", " + a.getY() + ") ");
        else
            System.out.print("none");
        System.out.println();
    }

    public boolean cellEmpty(int x, int y) {
        if (pieces.isNull(x, y))
            return true;
        return false;
    }

    public Piece getPieceByReal(float x, float y) {
        for (Piece p : pieces)
            if (x > p.getRealX() && x < p.getRealX() + sprite.getWidth() / 8)
                if (y > p.getRealY()
                        && y < p.getRealY() + sprite.getHeight() / 8)
                    return p;
        return null;
    }

    public Piece getPiece(int x, int y) {
        return pieces.get(x, y);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getSize() {
        return sprite.getWidth();
    }

    public void setSize(float size) {
        sprite.setSize(size, size);
    }

    public int getVirtX(float x) {
        x -= sprite.getX();
        int a = (int) sprite.getWidth() / 8;
        return (int) x / a;
    }

    public int getVirtY(float y) {
        y -= sprite.getY();
        int a = (int) sprite.getHeight() / 8;
        return (int) y / a;
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void setCenter(int x, int y) {
        sprite.setCenter(x, y);
    }

    public void dispose() {
        texture.dispose();
    }

}
