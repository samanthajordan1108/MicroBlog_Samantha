import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class BlogApp
{	
	static User currentUser;
	public ArrayList<Post> allPosts = new ArrayList<Post>();
	public ArrayList<User> allUsers = new ArrayList<User>();
    Scanner keyboard = new Scanner(System.in);
    
    User cindyLou = new User("WhoVille23", "Cindy Lou", "Who", "cindylouwho@gmail.com", "www.avatarpic.com");
    User johnDoe = new User("JohnDoe500", "John", "Doe", "johndoedee@gmail.com", "www.avatarpic.com");
	User janeSmith = new User("JaneAndTarzan5", "Jane", "Smith", "janeandtarzan5@gmail.com", "www.avatarpic.com");
	Post cindyLou1 = new Post(cindyLou, "Christmas is only 4 weeks away!", "www.christmastime.com");
	Post cindyLou2 = new Post(cindyLou , "My baby just turned a year old.", "www.babycenter.com");
	Post johnDoe1 = new Post(johnDoe, "I just got accepted into graduate school.", "www.harvard.com");
	Post johnDoe2 = new Post(johnDoe, "Only 1 more week until Spring Break!", "www.destinflorida.com");
	Post janeSmith1 = new Post(janeSmith , "We are expecting a baby due August 2017!", "www.parenting.com");
	
	public String printMenu() {
		String menuDisplay = "Main Menu:\n1) Create a new user\n2) Become an existing user\n3) Create a Post as the current user\n4) Print all posts\n5) print all users";
		return menuDisplay;
	}
	
	public ArrayList<User> currentUsers() {
		allUsers.add(0, cindyLou);
		allUsers.add(1, johnDoe);
		allUsers.add(2, janeSmith);
		return allUsers;
	}
	
	public ArrayList<Post> currentPosts() {
		allPosts.add(cindyLou1);
		allPosts.add(johnDoe1);
		allPosts.add(janeSmith1);
		allPosts.add(cindyLou2);
		allPosts.add(johnDoe2);
		return allPosts;
	}
	public void addPostsToUsers(){
		allUsers.get(0).addPost(cindyLou1);
		allUsers.get(0).addPost(cindyLou2);
		allUsers.get(1).addPost(johnDoe1);
		allUsers.get(1).addPost(johnDoe2);
		allUsers.get(2).addPost(janeSmith1);
	}
	
	public void createUser() {
		String username;
		String firstName;
		String lastName;
		String email;
		String URL;
		System.out.println("What is the username?");
		username = keyboard.next();
		System.out.println("What's the first name?");
		firstName = keyboard.next();
		System.out.println("What's the last name?");
		lastName = keyboard.next();
		System.out.println("What's the e-mail?");
		email = keyboard.next();
		System.out.println("What's the URL for the avatar picture?");
		URL = keyboard.next();
		User newUser = new User(username, firstName, lastName, email, URL);
		allUsers.add(newUser);

	}

	public void setExistingUser() {
		
		Iterator<User> iter = allUsers.iterator();
		System.out.println("Please select the number of the user you wish to select:");
		int counter=1;
		while (iter.hasNext()) {
			User u = (User) iter.next();
			System.out.println(counter+":  " +u.printUserInfo());
			System.out.println();
			counter++;
		}
		int userSelection = keyboard.nextInt();
		currentUser = allUsers.get(userSelection-1);
		System.out.println("You are now current user \n"+ currentUser);
		currentUser.printLastPost();
		

	}
	
	public void createPost() {
		String post;
		String webAddress;
		System.out.println("You are currently user: " + currentUser);
		System.out.println("New Post: ");
		post = keyboard.nextLine();
		System.out.println("What's the webAddress you want to site?");
		
		//*****
		webAddress = keyboard.next();
		Post newPost = new Post(currentUser, post, webAddress);
		allPosts.add(newPost);
		currentUser.addPost(newPost);
	}

	public void printPosts() {
		Iterator<Post> iter = allPosts.iterator();
		System.out.println("\nPosts:");
		while (iter.hasNext()) {
			Post p = (Post) iter.next();
			System.out.println(p.getPost());
		}
	}

	public void printUsers() {
		Iterator<User> iter = allUsers.iterator();
		System.out.println("\nUsers:");
		while (iter.hasNext()) {
			User u = (User) iter.next();
			System.out.println(u.printUserInfo());
		}
	}
	
	public void runApp(){
		int menuSelection=0;    	    	    	
        System.out.println("Welcome to the MicroBlog App!");
        currentUsers();
        currentPosts();
        addPostsToUsers();
        
        do{
        	
        	String menuDisplay=printMenu();
        	System.out.println(menuDisplay);
        
        	menuSelection=keyboard.nextInt();
        	if(menuSelection==1)
        	{
        		createUser();
        	}
        	else if(menuSelection==2)
        	{
        		setExistingUser();
        	}
        	else if(menuSelection==3)
        	{
        		createPost();
        	}
        	else if(menuSelection==4)
        	{
              	for (Post post : allPosts) {
					System.out.println(post);
					}
        	}
        	else if(menuSelection==5)
        	{
       		
        		for (User user : allUsers) {
					System.out.println(user);
				}
        		
        	}
           	
        }while(menuSelection!=9);
              
    
	}
	
    public static void main(String[] args)
    {
    	new BlogApp().runApp();
    }
 }


