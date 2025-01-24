package com.example;
/**
 * La classe Persona aiuta lo sviluppatore a gestire dati di tipo Persona
 * 
 * @author Fondati-Pietro
 */
public class Persona {

    private String nome;
    private String cognome;
    private String codiceFiscale;

    /**
     * Costruisce un oggetto Persona dato il nome, il cognome e il codice fiscale.
     * 
     * @param nome     Nome della persona
     * @param cognome  Cognome della persona
     * @param codice   Codice fiscale della persona
     * @throws IllegalArgumentException Se il codice fiscale fornito non è valido
     */
    public Persona(String nome, String cognome, String codice) {
        if (!isValidCodiceFiscale(codice)) {
            throw new IllegalArgumentException("Codice fiscale non valido.");
        }
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codice.toUpperCase();
    }

    /**
     * Restituisce il nome della persona
     * 
     * @return Nome della persona
     */
    public String getNome() {
        return nome;
    }

    /**
     * Assegna un nuovo nome alla persona
     * 
     * @param nome Nuovo nome da inserire
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome della persona
     * 
     * @return Cognome della persona
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Assegna un nuovo cognome alla persona
     * 
     * @param cognome Nuovo cognome da inserire
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Determina se due persone sono omonime (stesso nome, ignorando maiuscole e minuscole).
     * 
     * @param p Oggetto Persona con cui fare il confronto
     * @return true se le due persone hanno lo stesso nome, altrimenti false.
     */
    public boolean isOmonimo(Persona p) {
        return this.nome.equalsIgnoreCase(p.nome);
    }

    /**
     * Restituisce una esempio testuale di una persona
     * 
     * @return Una stringa: "NOME:... COGNOME:... CF:..."
     */
    @Override
    public String toString() {
        return String.format("NOME:%s COGNOME:%s CF:%s", nome, cognome, codiceFiscale);
    }

    /**
     * Verifica la validità di un codice fiscale
     * 
     * @param codice Codice fiscale da verificare
     * @return true se il codice è valido, altrimenti false
     */
    private boolean isValidCodiceFiscale(String codice) {
        if (codice == null || codice.length() != 16) {
            return false;
        }

        String upperCodice = codice.toUpperCase();
        for (int i = 0; i < 6; i++) {
            if (!Character.isLetter(upperCodice.charAt(i)) || isVowel(upperCodice.charAt(i))) {
                return false;
            }
        }

        for (int i = 6; i < 8; i++) {
            if (!Character.isDigit(upperCodice.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determina se un carattere è una vocale
     * 
     * @param c Carattere da controllare
     * @return true se il carattere è una vocale, altrimenti false
     */
    private boolean isVowel(char c) {
        return "AEIOU".indexOf(Character.toUpperCase(c)) != -1;
    }
}
