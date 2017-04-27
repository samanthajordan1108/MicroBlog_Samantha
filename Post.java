
public class Post
{
    static int nextPostNumber=1;
    private int postNumber;
    private User user;
    private String post;
    private String webAddress;
    
    
    public Post(User user, String post, String webAddress)
    {
        this.user= user;
        this.post=post;
        this.webAddress=webAddress;
        this.postNumber=nextPostNumber;
        nextPostNumber++;
        
    }
    public int getPostNumber()
    {
        return postNumber;
    }
  
    public String getPost()
    {
        return "post number: "+postNumber+"--"+post+"Web Address:"+webAddress+"/n";
    }
    public String toString(){
    	return getPost();
    }
    public String getPostText(){
    	return post;
    }
    
    
}