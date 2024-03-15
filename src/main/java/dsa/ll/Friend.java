package dsa.ll;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;


public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        Set<Friend> visited = new HashSet<>();
        Stack<Friend> friends = new Stack<>();
        friends.push(this);

        while(!friends.isEmpty()) {
            Friend current = friends.pop();
            visited.add(current);
            if (current.equals(friend)) {
                return true;
            }
            for(Friend currentFriend : current.getFriends()) {
                if(!visited.contains(currentFriend)){
                    friends.push(currentFriend);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}
