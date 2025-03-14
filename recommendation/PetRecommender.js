import fs from 'fs';

export class PetRecommender {
  constructor() {
    this.customers = [];
  }
  recommendPet(customer) {
    const { name, lifestyle, housing, familyMembers } = customer; //분해 할당
    if (
      lifestyle === '활동적' &&
      housing === '단독주택' &&
      familyMembers === '어린이 없음'
    ) {
      customer.recommenedPet = '골든리트리버';
    } else if (
      lifestyle === '조용한' &&
      housing === '아파트' &&
      familyMembers === '어린이 있음'
    ) {
      customer.recommenedPet = '고양이';
    }
    this.customers.push({ name: name, recommenedPet: customer.recommenedPet });
  }
  saveToFile() {
    console.log(this.customers);
    // JSON 파일로 저장
    fs.promises.appendFile(`./pet_recommendations.json`, this.customers);
  }
}
