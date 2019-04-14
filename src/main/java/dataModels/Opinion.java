package dataModels;

public class Opinion {
    private    User user;
    private RatingValue rating;
    private String opinionText;


    public Opinion(User user, RatingValue rating, String opinionText){
        this.user = user;
        this.rating = rating;
        this.opinionText = opinionText;

    }
    public User getUser() { return user; }

    public RatingValue getRating() {
        return rating;
    }

    public String getOpinionText() {
        return opinionText;
    }

    @Override
    public String toString(){
        return this.opinionText;
    }
}

