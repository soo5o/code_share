export class Customer {
  constructor(name, lifestyle, housing, familyMembers, recommenedPet = '') {
    this.name = name;
    this.lifestyle = lifestyle;
    this.housing = housing;
    this.familyMembers = familyMembers;
    this.recommenedPet = recommenedPet;
  }
}
