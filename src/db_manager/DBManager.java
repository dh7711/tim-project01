package db_manager;

import java.util.ArrayList;

import db_dto.NewStDTO;

public interface DBManager {
	public void display();
	public ArrayList<NewStDTO> getlist();
	public NewStDTO search( String id );
}
