import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptRejectSmartmeterComponent } from './accept-reject-smartmeter.component';

describe('AcceptRejectSmartmeterComponent', () => {
  let component: AcceptRejectSmartmeterComponent;
  let fixture: ComponentFixture<AcceptRejectSmartmeterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcceptRejectSmartmeterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcceptRejectSmartmeterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
