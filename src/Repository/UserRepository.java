package Repository;

import Exceptions.DuplicateUserExceptions;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {


	// to jest trochę niepoprawne ale nie bedziemy tworzyć klasy dla jednej zmienne

	public static boolean runFlag=true;
	public static String bean="losowy cąg znaków dodawany do hasła zwiększający docelową ilośc haseł";

	private List<User> userList=new ArrayList<>();
	private static final UserRepository userRepository=new UserRepository();
	// on nie musi być final ale lepiej bo podkreślamy ze referencja będzie niezmienna

	// nie chcemy uzywac publicznego konstruktora bo on ma dostep publiczny i
	// mógłby zostaż wykonany a tak to my decydujemy kto wywoła naszego konstruktora
	private UserRepository() {
	}

	public static UserRepository getUserRepository(){
		return UserRepository.userRepository;
			}

	public void addUser(User user){
		User userFromDB=getUserByLogin(user.getLogin());
		if(userFromDB==null) {
			this.userList.add(user);
		}else {
			throw new DuplicateUserExceptions("Już jest taki user");
			// konstruktor nowego wyjątku = obiektu
		}

	}

	public void printUsers(){
		System.out.println("hmmmm");
}


	public User getUserByLogin(String login) {
		for (User user : this.userList) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
	return null;
	}

}
