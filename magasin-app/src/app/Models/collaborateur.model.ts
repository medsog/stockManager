export class collaborateur.model.ts {
  constructor(
    public id: number,
	public Code: string,
	public Nom_prenom: string,
	public Pays: number,
	public Ville: number,
	public Adresse: string,
	public Tel: string,
	public Portable: string,
	public Fax: string,
	public E_Mail: string,
	public Site_Web: string,
	public id_type: number
  ) {  }
}