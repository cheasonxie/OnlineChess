package com.rextuz.onlinechess.pieces;

import com.badlogic.gdx.graphics.Texture;
import com.rextuz.onlinechess.Board;

public class Available extends Piece {
	private static final long serialVersionUID = 1L;
	private boolean offencive;

	public Available(int x, int y, Board board, int a) {
		super(x, y, "available", board);
		this.x = x;
		this.y = y;
		this.size = board.getSize() / 8;
		texture = new Texture("available.png");
		if (a != 0) {
			texture = new Texture("attack.png");
			offencive = true;
		} else
			offencive = false;
	}

	public boolean isOffencive() {
		return offencive;
	}

	public int[] getCoords() {
		return new int[] { x, y };
	}

	public int getA() {
		if (offencive)
			return 1;
		return 0;
	}
}
