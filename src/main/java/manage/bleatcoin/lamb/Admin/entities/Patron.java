package manage.bleatcoin.lamb.Admin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Objects;

@Document
public class Patron {
    @Id
    private int id;
    private String username;
	private int coins;

    public Patron() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
		
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron p = (Patron) o;
        return Objects.equals(getId(), p.getId()) &&
				Objects.equals(getCoins(), p.getCoins()) &&
                Objects.equals(getUsername(), p.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCoins(), getUsername());
    }

    @Override
    public String toString() {
        return "Patron {" +
                "id='" + id + '\'' +
                "username='" + username + '\'' +
				", coins='" + Integer.toString(coins) + '\'' +
                '}';
    }
}
