package vaccination_analysis.models;

// stores variables that can be exportet to Excel, Object created @ExcelExportFactory
public class ExcelExport {
	
	
	public ExcelExport(String username, boolean isAntivaxxer,
			int amountOfFriends, int amountOfFollowers,
			float meanNumberOfMentions, float meanNumberOfHashstags,
			float meanNumberOfHtmls, float meanTextLength, int messagesPosted,
			int daysOnTwitter, int messagesFavorited, float frequency_I,
			float frequency_The, float frequency_And, float frequency_To,
			float frequency_A, float frequency_Of, float frequency_That,
			float frequency_In, float frequency_It, float frequency_My,
			float frequency_Is, float frequency_You, float frequency_Was,
			float frequency_For, float frequency_Have, float frequency_With,
			float frequency_He, float frequency_Me, float frequency_On,
			float frequency_But) {
		super();
		this.username = username;
		this.isAntivaxxer = isAntivaxxer;
		this.amountOfFriends = amountOfFriends;
		this.amountOfFollowers = amountOfFollowers;
		this.meanNumberOfMentions = meanNumberOfMentions;
		this.meanNumberOfHashstags = meanNumberOfHashstags;
		this.meanNumberOfHtmls = meanNumberOfHtmls;
		this.meanTextLength = meanTextLength;
		this.messagesPosted = messagesPosted;
		this.daysOnTwitter = daysOnTwitter;
		this.messagesFavorited = messagesFavorited;
		this.frequency_I = frequency_I;
		this.frequency_The = frequency_The;
		this.frequency_And = frequency_And;
		this.frequency_To = frequency_To;
		this.frequency_A = frequency_A;
		this.frequency_Of = frequency_Of;
		this.frequency_That = frequency_That;
		this.frequency_In = frequency_In;
		this.frequency_It = frequency_It;
		this.frequency_My = frequency_My;
		this.frequency_Is = frequency_Is;
		this.frequency_You = frequency_You;
		this.frequency_Was = frequency_Was;
		this.frequency_For = frequency_For;
		this.frequency_Have = frequency_Have;
		this.frequency_With = frequency_With;
		this.frequency_He = frequency_He;
		this.frequency_Me = frequency_Me;
		this.frequency_On = frequency_On;
		this.frequency_But = frequency_But;
	}
	private String username;
	
	private boolean isAntivaxxer;
	private int amountOfFriends;
	private int amountOfFollowers;
	private float meanNumberOfMentions;
	private float meanNumberOfHashstags;
	private float meanNumberOfHtmls;
	private float meanTextLength;
	private int messagesPosted;
	private int daysOnTwitter;
	private int messagesFavorited;

	private float frequency_I;
	private float frequency_The;
	private float frequency_And;
	private float frequency_To;
	private float frequency_A;
	private float frequency_Of;
	private float frequency_That;
	private float frequency_In;
	private float frequency_It;
	private float frequency_My;
	private float frequency_Is;
	private float frequency_You;
	private float frequency_Was;
	private float frequency_For;
	private float frequency_Have;
	private float frequency_With;
	private float frequency_He;
	private float frequency_Me;
	private float frequency_On;
	private float frequency_But;



	public String getUsername() {
		return username;
	}
	public boolean isAntivaxxer() {
		return isAntivaxxer;
	}
	public int getAmountOfFriends() {
		return amountOfFriends;
	}
	public int getAmountOfFollowers() {
		return amountOfFollowers;
	}
	public float getMeanNumberOfMentions() {
		return meanNumberOfMentions;
	}
	public float getMeanNumberOfHashstags() {
		return meanNumberOfHashstags;
	}
	public float getMeanNumberOfHtmls() {
		return meanNumberOfHtmls;
	}
	public float getMeanTextLength() {
		return meanTextLength;
	}
	public int getMessagesPosted() {
		return messagesPosted;
	}
	public int getDaysOnTwitter() {
		return daysOnTwitter;
	}
	public int getMessagesFavorited() {
		return messagesFavorited;
	}
	public float getFrequency_I() {
		return frequency_I;
	}
	public float getFrequency_The() {
		return frequency_The;
	}
	public float getFrequency_And() {
		return frequency_And;
	}
	public float getFrequency_To() {
		return frequency_To;
	}
	public float getFrequency_A() {
		return frequency_A;
	}
	public float getFrequency_Of() {
		return frequency_Of;
	}
	public float getFrequency_That() {
		return frequency_That;
	}
	public float getFrequency_In() {
		return frequency_In;
	}
	public float getFrequency_It() {
		return frequency_It;
	}
	public float getFrequency_My() {
		return frequency_My;
	}
	public float getFrequency_Is() {
		return frequency_Is;
	}
	public float getFrequency_You() {
		return frequency_You;
	}
	public float getFrequency_Was() {
		return frequency_Was;
	}
	public float getFrequency_For() {
		return frequency_For;
	}
	public float getFrequency_Have() {
		return frequency_Have;
	}
	public float getFrequency_With() {
		return frequency_With;
	}
	public float getFrequency_He() {
		return frequency_He;
	}
	public float getFrequency_Me() {
		return frequency_Me;
	}
	public float getFrequency_On() {
		return frequency_On;
	}
	public float getFrequency_But() {
		return frequency_But;
	}

}
