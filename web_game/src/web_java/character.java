package web_java;

import java.io.Serializable;

public class character implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	private String userid;
	private String name;
	private String wish;
	private int Location;
	
	private int level;
	private int hp;
	private int mp;
	private int attack;
	private int deffence;
	private int armor;
	private int weapon;
	
	private boolean valid_flag;
	private int avata;

	public character() {
		super();
		// TODO Auto-generated constructor stub
	}

	public character(String userid, String name, String wish, int hp, int mp,
			int attack, int deffence, int avata) {
		super();
		this.userid = userid;
		this.name = name;
		this.wish = wish;
		this.hp = hp;
		this.mp = mp;
		this.attack = attack;
		this.deffence = deffence;
		this.avata = avata;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
	}

	public int getLocation() {
		return Location;
	}

	public void setLocation(int location) {
		Location = location;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDeffence() {
		return deffence;
	}

	public void setDeffence(int deffence) {
		this.deffence = deffence;
	}

	public boolean isValid_flag() {
		return valid_flag;
	}

	public void setValid_flag(boolean valid_flag) {
		this.valid_flag = valid_flag;
	}

	public int getAvata() {
		return avata;
	}

	public void setAvata(int avata) {
		this.avata = avata;
	}
	
}
