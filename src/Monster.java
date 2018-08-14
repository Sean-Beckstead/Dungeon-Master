
public class Monster {
	private int mHp;
	private int mInitiative;
	private String mName;
	private String mType;
	private int mStrength;
	private int mConstitution;
	private int mWisdom;
	private int mIntelligence;
	private int mDexterity;
	private int mCharisma;
	private int mAc;
	private int mReflex;
	private int mFortitude;
	private int mWill;
	private int mSpeed;	
	private String mAbilities;	
	private String[] mConditions = {""};
	
	public Monster(String name, String type, int hp) {
		setHp(hp);
		setName(name);
		setType(type);
		setInitiative(0);
		
	}

	public Monster(String name, String type, int hp, int speed, int ini, int str, int con, int wis, int intel, int dex, int charisma, int ac, int reflex, int fort, int will, String abilities) {
		setHp(hp);
		setInitiative(ini);
		setName(name);
		setType(type);
		setSpeed(speed);
		setStrength(str);
		setConstitution(con);
		setWisdom(wis);
		setIntelligence(intel);
		setDexterity(dex);
		setCharisma(charisma);
		setAc(ac);
		setReflex(reflex);
		setFortitude(fort);
		setWill(will);	
		setAbilities(abilities);	
	}
	
	public int getHp() {
		return mHp;
	}

	public void setHp(int hp) {
		mHp = hp;
	}

	public int getInitiative() {
		return mInitiative;
	}

	public void setInitiative(int initiative) {
		mInitiative = initiative;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}
	
	public String[] getConditions() {
		return mConditions;
	}

	public void setConditions(String[] condition) {
		mConditions = condition;
	}

	public String getType() {
		return mType;
	}

	public void setType(String type) {
		mType = type;
	}

	/**
	 * @return the mSpeed
	 */
	public int getSpeed() {
		return mSpeed;
	}

	/**
	 * @param mSpeed the mSpeed to set
	 */
	public void setSpeed(int Speed) {
		mSpeed = Speed;
	}

	/**
	 * @return the mStrength
	 */
	public int getStrength() {
		return mStrength;
	}

	/**
	 * @param mStrength the mStrength to set
	 */
	public void setStrength(int Strength) {
		mStrength = Strength;
	}

	/**
	 * @return the mConstitution
	 */
	public int getConstitution() {
		return mConstitution;
	}

	/**
	 * @param mConstitution the mConstitution to set
	 */
	public void setConstitution(int Constitution) {
		mConstitution = Constitution;
	}

	/**
	 * @return the mWisdom
	 */
	public int getWisdom() {
		return mWisdom;
	}

	/**
	 * @param mWisdom the mWisdom to set
	 */
	public void setWisdom(int Wisdom) {
		mWisdom = Wisdom;
	}

	/**
	 * @return the mIntelligence
	 */
	public int getIntelligence() {
		return mIntelligence;
	}

	/**
	 * @param mIntelligence the mIntelligence to set
	 */
	public void setIntelligence(int Intelligence) {
		mIntelligence = Intelligence;
	}

	/**
	 * @return the mDexterity
	 */
	public int getDexterity() {
		return mDexterity;
	}

	/**
	 * @param mDexterity the mDexterity to set
	 */
	public void setDexterity(int Dexterity) {
		mDexterity = Dexterity;
	}

	/**
	 * @return the mCharisma
	 */
	public int getCharisma() {
		return mCharisma;
	}

	/**
	 * @param mCharisma the mCharisma to set
	 */
	public void setCharisma(int Charisma) {
		mCharisma = Charisma;
	}

	/**
	 * @return the mAc
	 */
	public int getAc() {
		return mAc;
	}

	/**
	 * @param mAc the mAc to set
	 */
	public void setAc(int Ac) {
		mAc = Ac;
	}

	/**
	 * @return the mReflex
	 */
	public int getReflex() {
		return mReflex;
	}

	/**
	 * @param mReflex the mReflex to set
	 */
	public void setReflex(int Reflex) {
		mReflex = Reflex;
	}

	/**
	 * @return the mFortitude
	 */
	public int getFortitude() {
		return mFortitude;
	}

	/**
	 * @param mFortitude the mFortitude to set
	 */
	public void setFortitude(int Fortitude) {
		mFortitude = Fortitude;
	}

	/**
	 * @return the mWill
	 */
	public int getWill() {
		return mWill;
	}

	/**
	 * @param mWill the mWill to set
	 */
	public void setWill(int Will) {
		mWill = Will;
	}

	/**
	 * @return the mAbilities
	 */
	public String getAbilities() {
		return mAbilities;
	}

	/**
	 * @param mAbilities the mAbilities to set
	 */
	public void setAbilities(String Abilities) {
		mAbilities = Abilities;
	}
	
}
	

