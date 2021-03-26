package utilities;

public enum City {
	Abandikiti,
	B�labo,
	Foumbot,
	AbongMbang("Abong Mbang"),
	B�lel,
	Fumban,
	AkomII("Akom II"),
	Belo,
	Fundong,
	Akono,
	Bertoua,
	Garoua,
	Akonolinga,
	B�tar�Oya("B�tar� Oya"),
	GarouaBoula�("Garoua Boula�"),
	AkwabanaIsland("Akwabana Island"),
	BobiaIsland("Bobia Island"),
	Guidder,
	Ambam,
	Bogo,
	HyomaNaw�tia("Hyoma Naw�tia"),
	AmbasIsland("AmbasIsland"),
	Bonab�ri,
	Idenao,
	Babanki,
	Bota,
	IleAnna("Ile Anna"),
	Bafang,
	Bu�a,
	�leBouhangu�("�le Bouhangu�"),
	Bafia,
	CamptonIsland("Campton Island"),
	�leDibongo("�le Dibongo"),
	Bafoussam,
	Diang,
	IleDj�bal�("Ile Dj�bal�"),
	Bali,
	Dibombari,
	�leKw�l�Kw�l�("�le Kw�l�Kw�l�"),
	Bamenda,
	Dimako,
	�leMalimba("�le Malimba"),
	Bamendjou,
	Dizangu�,
	IleManoka("�le Malimba"),
	Bamkim,
	Djohong,
	IleMiandjou("Ile Miandjou"),
	Bamusso,
	Douala,
	IleNdonga("Ile Ndonga"),
	Bana,
	Doum�,
	�leNicol("�le Nicol"),
	Bandjoun,
	Dschang,
	�lePongo("�le Pongo"),
	Bangangt�,
	�bolowa,
	IleWouri("Ile Wouri"),
	Bansoa,
	�d�a,
	IleYatou("Ile Yatou"),
	Banyo,
	Es�ka,
	InikoiIsland("Inikoi Island"),
	Bat�na,
	Ess�,
	Jakiri,
	Batibo,
	�vodoula,
	Kabanha,
	Batouri,
	EwuruIsland("Ewuru Island"),
	Ka�l�,
	Bazou,
	FiariIsland("Fiari Island"),
	Kat�la,
	Bekondo,
	Fontem,
	Kontcha,
	Mindif,
	Obala,
	Kouss�ri,
	Minjame,
	Okoa,
	Koza,
	Minta,
	Okola,
	Kribi,
	Mokolo,
	Ombessa,
	Kumba,
	MondolehIsland("Mondoleh Island"),
	Ot�rou,
	Kumbo,
	Mora,
	Penja,
	Lagdo,
	Mouanko,
	Piparla,
	Limb�,
	Mouyouka,
	Pitoa,
	Lolodorf,
	Mundenba,
	Poli,
	Loum,
	Mutengene,
	Pon,
	LuckeIsland("Lucke Island"),
	Mvangu�,
	ReyBouba("Rey Bouba"),
	Makary,
	NangaEboko("Nanga Eboko"),
	Saa,
	Mamfe,
	Ndeba,
	Sangm�lima,
	Manjo,
	Nd�l�l�,
	SchiessIsland,
	Maroua,
	Ndikinim�ki,
	SodenIsland("Soden Island"),
	MasonjoIsland("Masonjo Island"),
	Ndom,
	Tchollir�,
	Mbalmayo,
	Nganb�,
	Tibati,
	Mbandjok,
	Ngaundere,
	Tign�re,
	Mbang,
	Ngomedzap,
	Tiko,
	Mbanga,
	Ngorro,
	TikoIsland("Tiko Island"),
	Mbankomo,
	Ngou,
	Tonga,
	Mb�g�,
	Nguti,
	Wum,
	Mbengwi,
	Njinikom,
	Yabassi,
	Mbouda,
	Nkoloboko,
	Yagoua,
	Me,
	Nkongsamba,
	Yaound�,
	Meiganda,
	Nkoteng,
	Yokadouma,
	Melong,
	Ntui,
	Yoko;
	
	private final String lastName;
	
	City(){
		this.lastName = super.name();
		
	}
	
	City(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return this.toString();
	}
	
}
