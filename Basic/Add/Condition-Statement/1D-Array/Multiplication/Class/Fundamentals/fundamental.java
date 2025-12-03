class User {
    String username;   
    String email;      
    int followers;     

void postPhoto(String photoDescription) {
        System.out.println(username + " posted a photo: " + photoDescription);
    }

void likePost(String post) {
        System.out.println(username + " liked the post: " + post);
    }

void follow(User otherUser) {
        System.out.println(username + " followed " + otherUser.username);
    }
}
