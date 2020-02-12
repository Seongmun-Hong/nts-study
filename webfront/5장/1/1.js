function Health(name, lastTime) {
    this.name = name;
    this.lastTime = lastTime;
    this.showHealth = function(){
        console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요");      
    }
}
const healthObject = new Health("크롱", "AM 10:12");

const healthObject2 = new Health("호눅스", "PM 10:12");

healthObject.showHealth();
healthObject2.showHealth();