import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEnableDisableProviderComponent } from './view-enable-disable-provider.component';

describe('ViewEnableDisableProviderComponent', () => {
  let component: ViewEnableDisableProviderComponent;
  let fixture: ComponentFixture<ViewEnableDisableProviderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEnableDisableProviderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewEnableDisableProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
