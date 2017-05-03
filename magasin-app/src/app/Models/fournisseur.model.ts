export class fournisseur.model.ts {
  constructor(
    public id_fournisseur: number,
	public Code: string,
	public Identite: string,
	public Raison_Sociale: string,
	public Pays: number,
	public Ville: number,
	public Adresse: string,
	public Tel: string,
	public Portable: string,
	public Fax: string,
	public E_Mail: string,
	public Site_Web: string
	
  ) {  }
}