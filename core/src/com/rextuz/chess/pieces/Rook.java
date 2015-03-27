package com.rextuz.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.rextuz.chess.Board;
import com.rextuz.chess.OnlineChess;
import com.rextuz.chess.anim.Avalible;

public class Rook extends Piece {

	public Rook(int x, int y, String color, Board board) {
		super(x, y, color, board);
		texture = new Texture("rook_" + color + ".png");
	}

	@Override
	public List<Avalible> moves() {
		List<Avalible> list = new ArrayList<Avalible>();
		int xt, yt;
		xt = x + 1;
		yt = y;
		while (xt < 8 && OnlineChess.board.cellEmpty(xt, yt)) {
			list.add(new Avalible(xt, yt, size, board, 0));
			xt++;
		}
		if (board.getPiece(xt, yt) != null)
			if (!board.getPiece(xt, yt).getColor().equals(color))
				list.add(new Avalible(xt, yt, size, board, 1));
		xt = x - 1;
		while (xt > -1 && OnlineChess.board.cellEmpty(xt, yt)) {
			list.add(new Avalible(xt, yt, size, board, 0));
			xt--;
		}
		if (board.getPiece(xt, yt) != null)
			if (!board.getPiece(xt, yt).getColor().equals(color))
				list.add(new Avalible(xt, yt, size, board, 1));
		xt = x;
		yt = y + 1;
		while (yt < 8 && OnlineChess.board.cellEmpty(xt, yt)) {
			list.add(new Avalible(xt, yt, size, board, 0));
			yt++;
		}
		if (board.getPiece(xt, yt) != null)
			if (!board.getPiece(xt, yt).getColor().equals(color))
				list.add(new Avalible(xt, yt, size, board, 1));
		yt = y - 1;
		while (yt > -1 && OnlineChess.board.cellEmpty(xt, yt)) {
			list.add(new Avalible(xt, yt, size, board, 0));
			yt--;
		}
		if (board.getPiece(xt, yt) != null)
			if (!board.getPiece(xt, yt).getColor().equals(color))
				list.add(new Avalible(xt, yt, size, board, 1));
		return list;
	}
}
