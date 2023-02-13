import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrollProviderComponent } from './enroll-provider.component';

describe('EnrollProviderComponent', () => {
  let component: EnrollProviderComponent;
  let fixture: ComponentFixture<EnrollProviderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnrollProviderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnrollProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
