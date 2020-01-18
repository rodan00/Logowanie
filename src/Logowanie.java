import Gui.Gui;
import Repository.UserRepository;

import static Repository.UserRepository.runFlag;

public class Logowanie {



	public static void main(String[] args) {


		while(UserRepository.getUserRepository().runFlag){
			Gui.showMenu();
		}


		// ma się wyświetlać menu logowania






	}



}
