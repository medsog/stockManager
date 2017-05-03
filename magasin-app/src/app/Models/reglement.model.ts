export class reglement.model.ts {
  constructor(
    public id: number,
    public date: string,
    public mode_paiement: number,
    public id_client: number,
	public montant: number,
	public solde: number,
  ) {  }
}