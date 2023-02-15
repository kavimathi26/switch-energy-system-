import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSmartmeterListComponent } from './view-smartmeter-list.component';

describe('ViewSmartmeterListComponent', () => {
  let component: ViewSmartmeterListComponent;
  let fixture: ComponentFixture<ViewSmartmeterListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewSmartmeterListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewSmartmeterListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
