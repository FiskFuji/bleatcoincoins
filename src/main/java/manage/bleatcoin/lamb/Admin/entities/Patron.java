package manage.bleatcoin.lamb.Admin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Patron {
    @Id
    private int id;
    private String username;
    private String realname;
    private String tier;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron p = (Patron) o;
        return Objects.equals(getId(), p.getId()) &&
                Objects.equals(getCoins(), p.getCoins()) &&
                Objects.equals(getRealname(), p.getRealname()) &&
                Objects.equals(getTier(), p.getTier()) &&
                Objects.equals(getUsername(), p.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCoins(),  getRealname(), getTier(), getUsername());
    }

    @Override
    public String toString() {
        return "Patron {" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", tier='" + tier + '\'' +
				", coins='" + Integer.toString(coins) + '\'' +
                '}';
    }
}
