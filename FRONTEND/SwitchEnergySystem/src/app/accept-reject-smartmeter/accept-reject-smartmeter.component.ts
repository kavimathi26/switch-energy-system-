import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { userEnrollType } from '../user-display/user-enroll-type';
import { smartMeterType } from './smartMeterType';

@Component({
  selector: 'app-accept-reject-smartmeter',
  templateUrl: './accept-reject-smartmeter.component.html',
  styleUrls: ['./accept-reject-smartmeter.component.css']
})
export class AcceptRejectSmartmeterComponent implements OnInit {

  constructor(private service: Provider) { }

  ngOnInit(): void {
    this.getUserWithSmartMetersPending();
  }
  userName = "Kavi123"
  userDetails: Array<smartMeterType> = [];
  getUserWithSmartMetersPending() {
    this.service.getUserWithSmartMetersPending("Kavi123").subscribe((res) => {
      console.log(res);
      this.userDetails = res;
    })
  }
  editApprovalStatus(smartMeterId: String) {
    this.service.approveSmartMeter("accepted", smartMeterId).subscribe((res) => {
      console.log(res);
      window.location.reload();
    })
  }
  editApprovalStatusReject(smartMeterId: String) {
    this.service.approveSmartMeter("rejected", smartMeterId).subscribe((res) => {
      console.log(res);
      window.location.reload();
    })
  }
}
