import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatedocComponent } from './updatedoc.component';

describe('UpdatedocComponent', () => {
  let component: UpdatedocComponent;
  let fixture: ComponentFixture<UpdatedocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatedocComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatedocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
