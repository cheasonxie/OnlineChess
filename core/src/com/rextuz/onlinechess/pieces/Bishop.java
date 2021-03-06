package com.rextuz.onlinechess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.rextuz.onlinechess.Board;

public class Bishop extends Piece {
	private static final long serialVersionUID = 1L;

	public Bishop(int x, int y, String color, Board board) {
		super(x, y, color, board);
		texture = new Texture("bishop_" + color + ".png");
	}

	@Override
	public List<Available> getMoves() {
		List<Available> list = new ArrayList<Available>();
		int xt, yt;

		xt = x + 1;
		yt = y + 1;
		while (valid(xt, yt) && board.cellEmpty(xt, yt)) {
			list.add(new Available(xt, yt, board, 0));
			xt++;
			yt++;
		}
		if (valid(xt, yt))
			if (!board.pieces.get(xt, yt).getColor().equals(color))
				list.add(new Available(xt, yt, board, 1));

		xt = x - 1;
		yt = y - 1;
		while (valid(xt, yt) && board.cellEmpty(xt, yt)) {
			list.add(new Available(xt, yt, board, 0));
			xt--;
			yt--;
		}
		if (valid(xt, yt))
			if (!board.pieces.get(xt, yt).getColor().equals(color))
				list.add(new Available(xt, yt, board, 1));

		xt = x + 1;
		yt = y - 1;
		while (valid(xt, yt) && board.cellEmpty(xt, yt)) {
			list.add(new Available(xt, yt, board, 0));
			xt++;
			yt--;
		}
		if (valid(xt, yt))
			if (!board.pieces.get(xt, yt).getColor().equals(color))
				list.add(new Available(xt, yt, board, 1));

		xt = x - 1;
		yt = y + 1;
		while (valid(xt, yt) && board.cellEmpty(xt, yt)) {
			list.add(new Available(xt, yt, board, 0));
			xt--;
			yt++;
		}
		if (valid(xt, yt))
			if (!board.pieces.get(xt, yt).getColor().equals(color))
				list.add(new Available(xt, yt, board, 1));

		return list;
	}
}
