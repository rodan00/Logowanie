package Gui;

import Model.User;
import Repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class Gui {


	private static Scanner scanner=new Scanner(System.in);

	public static void showMenu() {

		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Exit");

		String choose = Gui.scanner.nextLine();
		switch (choose) {

			case "1":
				showRegisterScreen();
				break;
			case "2":
				showLoginScreen();
				break;
			case "3":
			// robimy zamykanie przez FLAGĘ
			UserRepository.getUserRepository().runFlag=false;
			case "god":
				UserRepository.getUserRepository().printUsers();
				break;
			//	System.exit(0);
			default:
				System.out.println("wybierz poprawną opcję");
				break;
		}
	}
	// te metody musza być statyczne bo są wywoływane z medoty statycznej ??
	private static void showLoginScreen() {

		System.out.println("Podaj login");
		String login = Gui.scanner.nextLine();

		System.out.println("Podaj hasło");
		String pass = Gui.scanner.nextLine();

		User userFromDB=UserRepository.getUserRepository().getUserByLogin(login);
		String hashedPass = DigestUtils.md5Hex(pass);

		// kolejność warunku jest istotna bo nie będzie generowany błąd
		if (userFromDB!=null && userFromDB.getPass().equals(hashedPass)) {
			System.out.println("Zalogowano");
		} else {
			System.out.println("Brak dostępu !!!");
		}
	}

	public static void showRegisterScreen() {
		boolean flag=true;
		int counter=0;

		do {

			System.out.println("Podaj login");
			String login = Gui.scanner.nextLine();

			System.out.println("Podaj hasło");
			String pass = Gui.scanner.nextLine();

			System.out.println("Powtórz hasło");
			String pass2 = Gui.scanner.nextLine();

			if (pass.equals(pass2)) {
				String hash = DigestUtils.md5Hex("Janusz"+UserRepository.bean);
				System.out.println(hash);
				DigestUtils.md5Hex("Janusz");

				UserRepository ur = UserRepository.getUserRepository();
				User user = new User(login, DigestUtils.md5Hex(pass+UserRepository.bean));
				try {
					ur.UserRepository.addUser();
				} catch {
					System.out.println();
				}


				flag=false;         // zadziała przy poprawnym logowaniu !!
			}else{
				System.out.println(" Nieprawidłowe hasło");
				counter++;
				if(counter==3) {
					System.out.println("za dużo prób");
				}
			}
		} while (flag && counter<3);

		}
	}



