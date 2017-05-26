package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;

public class HarvCell {
	private ArrayList<FMember> fam = new ArrayList<FMember>();

	public ArrayList<FMember> getFam() {
		return fam;
	}

	public void setFam(ArrayList<FMember> fam) {
		this.fam = fam;
	}

}
