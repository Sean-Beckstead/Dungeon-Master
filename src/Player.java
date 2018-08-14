
public class Player {
	private String pName;
	private String pType;
	private int pHp;
	private int pInitiative;
	private int pStrength;
	private int pConstitution;
	private int pWisdom;
	private int pIntelligence;
	private int pDexterity;
	private int pCharisma;
	private int pAc;
	private int pReflex;
	private int pFortitude;
	private int pWill;
	private int pSpeed;
	private String pAbilities;	
	private String[] pConditions = {""};
	
	public Player(String name, String type, int hp) {
		setHp(hp);
		setInitiative(0);
		setName(name);
		setType(type);
	}
	
	public Player(String name, String type, int hp, int speed, int ini, int str, int con, int wis, int intel, int dex, int charisma, int ac, int reflex, int fort, int will, String abilities) {
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
		return pHp;
	}

	public void setHp(int Hp) {
		pHp = Hp;
	}

	public int getInitiative() {
		return pInitiative;
	}

	public void setInitiative(int Initiative) {
		pInitiative = Initiative;
	}

	public String getName() {
		return pName;
	}

	public void setName(String Name) {
		pName = Name;
	}
	
	public String[] getConditions() {
		return pConditions;
	}

	public void setConditions(String[] condition) {
		pConditions = condition;
	}

	public String getType() {
		return pType;
	}

	public void setType(String Type) {
		pType = Type;
	}

	/**
	 * @return the pSpeed
	 */
	public int getSpeed() {
		return pSpeed;
	}

	/**
	 * @param pSpeed the pSpeed to set
	 */
	public void setSpeed(int Speed) {
		pSpeed = Speed;
	}

	public int getStrength() {
		return pStrength;
	}

	public void setStrength(int Strength) {
		pStrength = Strength;
	}

	public int getConstitution() {
		return pConstitution;
	}

	public void setConstitution(int Constitution) {
		pConstitution = Constitution;
	}

	/**
	 * @return the pWisdom
	 */
	public int getWisdom() {
		return pWisdom;
	}

	/**
	 * @param pWisdom the pWisdom to set
	 */
	public void setWisdom(int Wisdom) {
		pWisdom = Wisdom;
	}

	/**
	 * @return the pIntelligence
	 */
	public int getIntelligence() {
		return pIntelligence;
	}

	/**
	 * @param pIntelligence the pIntelligence to set
	 */
	public void setIntelligence(int Intelligence) {
		pIntelligence = Intelligence;
	}

	/**
	 * @return the pDexterity
	 */
	public int getDexterity() {
		return pDexterity;
	}

	/**
	 * @param pDexterity the pDexterity to set
	 */
	public void setDexterity(int Dexterity) {
		pDexterity = Dexterity;
	}

	/**
	 * @return the pCharisma
	 */
	public int getCharisma() {
		return pCharisma;
	}

	/**
	 * @param pCharisma the pCharisma to set
	 */
	public void setCharisma(int Charisma) {
		pCharisma = Charisma;
	}

	/**
	 * @return the pAc
	 */
	public int getAc() {
		return pAc;
	}

	/**
	 * @param pAc the pAc to set
	 */
	public void setAc(int Ac) {
		pAc = Ac;
	}

	/**
	 * @return the pReflex
	 */
	public int getReflex() {
		return pReflex;
	}

	/**
	 * @param pReflex the pReflex to set
	 */
	public void setReflex(int Reflex) {
		pReflex = Reflex;
	}

	/**
	 * @return the pFortitude
	 */
	public int getFortitude() {
		return pFortitude;
	}

	/**
	 * @param pFortitude the pFortitude to set
	 */
	public void setFortitude(int Fortitude) {
		pFortitude = Fortitude;
	}

	/**
	 * @return the pWill
	 */
	public int getWill() {
		return pWill;
	}

	/**
	 * @param pWill the pWill to set
	 */
	public void setWill(int Will) {
		pWill = Will;
	}

	/**
	 * @return the pAbilities
	 */
	public String getAbilities() {
		return pAbilities;
	}

	/**
	 * @param pAbilities the pAbilities to set
	 */
	public void setAbilities(String Abilities) {
		pAbilities = Abilities;
	}
	
}

