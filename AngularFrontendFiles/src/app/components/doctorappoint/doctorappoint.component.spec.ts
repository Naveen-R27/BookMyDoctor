import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorappointComponent } from './doctorappoint.component';

describe('DoctorappointComponent', () => {
  let component: DoctorappointComponent;
  let fixture: ComponentFixture<DoctorappointComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorappointComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctorappointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
