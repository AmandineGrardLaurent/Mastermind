import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Mastermind {
	
	/*
	 * Récupère la saisie de l'utilisateur sous format string.
	 * Vérifie également que la saisie de l'utilisateur correspond au format attendu
	 */
	public static String getUserNumber(Scanner scan) {
		String numberStr;

		while (true) {
			System.out.println("================================");
			System.out.println("Votre nombre à 4 chiffres : ");
			numberStr = scan.next();

			// Vérifie que la saisie contient exactement 4 chiffres (regex)
		    if (numberStr.matches("\\d{4}")) { 
		    	break;
		    } 
		    else {
		        System.out.println("Veuillez entrer un nombre entre 0000 et 9999.");
		    }
		}
		return numberStr;
	}
	
	/**
	 * Convertit un chiffre string en tableau d'entier
	 * Ex : "1234" ---> [1, 2, 3, 4]
	 */
	public static int[] stringToIntArray(String str) {
		
		String [] strArray = str.split("");
		int [] intArray = new int[4];
		
		for (int i = 0; i < intArray.length; i ++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}

	/**
     * Convertit un tableau d'entier en string
     * Ex : [1, 2, 3, 4] ---> "1234"
     */
	public static String intArrayToString(int [] array) {
		String result = "";
		for (int number : array) {
		    result = result + number;
		}
		return result;
	}
	
	/**
	 * Génère un entier compris entre 0000 et 9999
	 * @return un tableau d'entier  [0,0,0,0]
	 */
	public static int[] generateRandomCode() {
		 Random random = new Random();
	     int[] intArray = new int[4];

	     for (int i = 0; i < 4; i++) {
	    	 intArray[i] = random.nextInt(10);
	     }
	     return intArray;
	}
	 
	/**
     * Compte les chiffres présents mais mal placés
     * Gère correctement les doublons grâce aux copies des tableaux
     */
	public static int countDigitsMisplaced(int[] secretCode, int[] userCode) {
	    int misplaced = 0;

	    // Crée des copies pour éviter de modifier les tableaux originaux
	    int[] secretCopy = Arrays.copyOf(secretCode, secretCode.length);
	    int[] userCopy = Arrays.copyOf(userCode, userCode.length);

	    // on modifie les copies des tableaux pour qu'ils
	    // ne soient pas compté lors du comptage des mal placés
	    for (int i = 0; i < 4; i++) {
	        if (secretCopy[i] == userCopy[i]) {
	            secretCopy[i] = -1;
	            userCopy[i] = -2;
	        }
	    }

	    // comptage des chiffres mal placés
	    // on modifie les copies des tableaux pour qu'ils
	    // ne soient pas compté plusieurs fois lors des doublons
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            if (secretCopy[i] == userCopy[j]) {
	                misplaced++;
	                secretCopy[i] = -1;
	                userCopy[j] = -2;
	                break;
	            }
	        }
	    }
	    return misplaced;
	}

	/**
     * Compte les chiffres bien placés
     * Même position et même valeur
     */
	public static int countDigitsCorrectPosition(int [] secretCode, int [] userCode) {
		int correctPositions = 0;
		for (int i = 0; i < secretCode.length; i++) {
				if (secretCode[i] == userCode[i]) {
					correctPositions ++;
			}
		}
		return correctPositions;
	}
	
	/**
     * Affiche des informations formatées à l'utilisateur
     */
	public static void displayInformations(String prompt, int number) {
		System.out.printf(prompt, number);
	}
	
	// Main -------------------------------------------------------------------
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] secretCodeArray; // code secret à trouver
		int [] userNumberArray; // nombre saisi par l'utilisateur
		int countCorrectPositions; // nombre de chiffres bien placés
		int countMisplaced; // nombre de chiffres mal placés
		String userNumberStr; // nombre saisi par l'utilisateur au format string
		int attemptCount;
	
		
		// génère le code secret
		secretCodeArray = generateRandomCode();
		System.out.println(Arrays.toString(secretCodeArray));
		
		// initialisation du nombre de chiffres bien placés
		countCorrectPositions = 0;
		
		// initialisation du compteur des essais de l'utilisateur
		attemptCount = 0;
		
		// boucle qui s'arrête lorsque le code a été trouvé par l'utilisateur 
		while (countCorrectPositions != 4) {
			
		// demande à l'utilisateur de saisir un nombre de 4 chiffres
		userNumberStr = getUserNumber(scan);
		
		// convertit le nombre de l'utilisateur en tableau d'entier
		userNumberArray = stringToIntArray(userNumberStr);
		
		// calcul des chiffres mal placés
		countMisplaced = countDigitsMisplaced(secretCodeArray, userNumberArray); 
		// calcul des chiffres bien placés
		countCorrectPositions = countDigitsCorrectPosition(secretCodeArray, userNumberArray);
		
		attemptCount++;
		
		// affichage des résultats
		displayInformations("Essai n°%s \n", attemptCount);
		displayInformations("%s chiffre(s) de mal placés \n",  countMisplaced);
		displayInformations("%s chiffre(s) de bien placés \n", countCorrectPositions);
		}
		
		System.out.printf("Bravo vous avez trouvé le code secret : %s", intArrayToString(secretCodeArray));

		scan.close();
	}
}