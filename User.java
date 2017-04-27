import java.util.ArrayList;
import java.util.Iterator;

public class User
{
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String URL;
    private ArrayList<Post> postArray= new ArrayList<>();
    
    public User(String username, String firstName, String lastName, String email, String URL)
    {
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.URL=URL;
    }
    
    public String printUserInfo()
    {
        return URL+" \n  " +username+" \n "+firstName+ " \n " + lastName+" \n "+email +" \n ";
    }
    
    public void addPost(Post post){
    		this.postArray.add(post);
    }
    
    
    public void getUserPosts(){
    
    	System.out.println("\nPosts for User " + username +":\n");
    	Iterator<Post> iter = postArray.iterator();
    	Post p = (Post)iter.next();
       	while(iter.hasNext())
        {
            System.out.println(p.getPostText());
        }
    }
    
    public void printLastPost(){
    	System.out.println("Your last post was : ");
    	if (postArray != null && !postArray.isEmpty()) {
    		  System.out.println(postArray.get(postArray.size()-1));
    		}
    	else{
    		System.out.println("no previous post \n\n");
    	}
 
    }
    
    public String toString(){
    	return printUserInfo();
    }
   
}