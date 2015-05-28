package vaccination_analysis.models;

import java.util.List;

import vaccination_analysis.textmining.StringUtilities;

public class WordFrequencies {
	
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

	
	public WordFrequencies(List<String> tweets) {
		StringUtilities su = new StringUtilities(tweets);

		this.frequency_I = su.getFrequencyHelper(" i ");
		this.frequency_Is = su.getFrequencyHelper(" is ");
		this.frequency_A = su.getFrequencyHelper(" a ");
		this.frequency_For = su.getFrequencyHelper(" for ");
		this.frequency_You = su.getFrequencyHelper(" u ")
				+ su.getFrequencyHelper(" you ");
		this.frequency_Have = su.getFrequencyHelper(" have ");
		this.frequency_That = su.getFrequencyHelper(" that ");
		this.frequency_In = su.getFrequencyHelper(" in ");
		this.frequency_Of = su.getFrequencyHelper(" of ");
		this.frequency_He = su.getFrequencyHelper(" he ");
		this.frequency_To = su.getFrequencyHelper(" to ");
		this.frequency_The = su.getFrequencyHelper(" the ");
		this.frequency_Was = su.getFrequencyHelper(" was ");
		this.frequency_And = su.getFrequencyHelper(" and ");
		this.frequency_Me = su.getFrequencyHelper(" me ");
		this.frequency_With = su.getFrequencyHelper(" with ")
				+ su.getFrequencyHelper(" /w ");
		this.frequency_But = su.getFrequencyHelper(" but ");
		this.frequency_It = su.getFrequencyHelper(" it ");
		this.frequency_My = su.getFrequencyHelper(" my ");
		this.frequency_On = su.getFrequencyHelper(" on ");
		
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
