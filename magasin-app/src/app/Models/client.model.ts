export class client.model.ts {
  constructor(
    public id_client: number,
	public Code: string,
	public Identite: string,
	public Nom: string,
	public Prenom: number,
	public Pays: number,
	public Ville: number,
	public Adresse: string,
	public Tel: string,
	public Portable: string,
	public Fax: string,
	public E_Mail: string,
	public Site_Web: string,
	public Date_Annivairsaire: string,
	public remise: number,
	public categorie: number
  ) {  }
}